#include "GaussianBlur.h"
#include <iostream>
#include <vector>
#include <cmath>

#define scale 2


int clip(int value) {
    return min(max(value, 0), 255);
}

void applyGaussianBlur(vector<vector<Pixel> >& image, float radius) {
    int n = image.size();
    int m = image[0].size();

    int kernelSize = static_cast<int>((2*radius + 1)/scale);
    if (kernelSize < 1) {
        return;
    }

    // Calculate Gaussian kernel coefficients
    vector<float> kernel(kernelSize);
    int sigma = kernelSize / 2;
    float sum = 0.0;
    for (int x = 0; x < kernelSize; ++x) {
        kernel[x] = exp(-(x - sigma) * (x - sigma) / (2 * sigma * sigma));
        sum += kernel[x];
    }

    // Normalize the coefficients
    for (float& coeff : kernel) {
        coeff /= sum;
    }

    // Apply separable horizontal blur
    vector<vector<Pixel> > tempImage(image);
    for (int i = 0; i < n; ++i) {
        for (int j = kernelSize / 2; j < m - kernelSize / 2; ++j) {
            float rtotal = 0.0, gtotal = 0.0, btotal = 0.0;

            for (int x = 0; x < kernelSize; ++x) {
                rtotal += kernel[x] * image[i][j + x - kernelSize / 2].r;
                gtotal += kernel[x] * image[i][j + x - kernelSize / 2].g;
                btotal += kernel[x] * image[i][j + x - kernelSize / 2].b;
            }

            tempImage[i][j].r = clip(static_cast<int>(rtotal));
            tempImage[i][j].g = clip(static_cast<int>(gtotal));
            tempImage[i][j].b = clip(static_cast<int>(btotal));
        }
    }

    // Apply separable vertical blur
    for (int i = kernelSize / 2; i < n - kernelSize / 2; ++i) {
        for (int j = 0; j < m; ++j) {
            float rtotal = 0.0, gtotal = 0.0, btotal = 0.0;

            for (int y = 0; y < kernelSize; ++y) {
                rtotal += kernel[y] * tempImage[i + y - kernelSize / 2][j].r;
                gtotal += kernel[y] * tempImage[i + y - kernelSize / 2][j].g;
                btotal += kernel[y] * tempImage[i + y - kernelSize / 2][j].b;
            }

            image[i][j].r = clip(static_cast<int>(rtotal));
            image[i][j].g = clip(static_cast<int>(gtotal));
            image[i][j].b = clip(static_cast<int>(btotal));
        }
    }
}
