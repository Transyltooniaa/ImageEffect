#include "GaussianBlur.h"
#include <iostream>
#include <vector>
#include <cmath>


// Scale factor for the Gaussian kernel
#define scale 2


// Clamps the given value to the range [0, 255]
int clip(int value) {
    return min(max(value, 0), 255);
}


// Applies Gaussian blur to the given image
void applyGaussianBlur(vector<vector<Pixel> >& image, float radius) {
    int n = image.size();
    int m = image[0].size();

    // Calculate the size of the Gaussian kernel
    int kernelSize = static_cast<int>((2*radius + 1)/scale);

    // If the radius is too small, don't blur
    if (kernelSize < 1) {
        return;
    }

    // Calculate Gaussian kernel coefficients
    vector<float> kernel(kernelSize);

    // Calculate the standard deviation
    int sigma = kernelSize / 2;

    // Calculate the coefficients
    float sum = 0.0;

    // Calculate the coefficients
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

    // Apply separable horizontal blur
    for (int i = 0; i < n; ++i)
    {
        for (int j = kernelSize / 2; j < m - kernelSize / 2; ++j)
        {

            // Apply separable horizontal blur to the temporary image
            float rtotal = 0.0, gtotal = 0.0, btotal = 0.0;

            // Apply separable horizontal blur to the temporary image
            for (int x = 0; x < kernelSize; ++x) {

                // Rt, Gt, Bt are the temporary values for the red, green and blue channels
                rtotal += kernel[x] * image[i][j + x - kernelSize / 2].r;
                gtotal += kernel[x] * image[i][j + x - kernelSize / 2].g;
                btotal += kernel[x] * image[i][j + x - kernelSize / 2].b;
            }

            // Assign the temporary values to the temporary image
            tempImage[i][j].r = clip(static_cast<int>(rtotal));
            tempImage[i][j].g = clip(static_cast<int>(gtotal));
            tempImage[i][j].b = clip(static_cast<int>(btotal));
        }
    }

    // Apply separable vertical blur
    for (int i = kernelSize / 2; i < n - kernelSize / 2; ++i)
    {

        // Apply separable vertical blur to the temporary image
        for (int j = 0; j < m; ++j) {
            // Rt, Gt, Bt are the temporary values for the red, green and blue channels
            float rtotal = 0.0, gtotal = 0.0, btotal = 0.0;

            for (int y = 0; y < kernelSize; ++y) {

                // Rt, Gt, Bt are the temporary values for the red, green and blue channels
                rtotal += kernel[y] * tempImage[i + y - kernelSize / 2][j].r;
                gtotal += kernel[y] * tempImage[i + y - kernelSize / 2][j].g;
                btotal += kernel[y] * tempImage[i + y - kernelSize / 2][j].b;
            }

            // Assign the temporary values to the temporary image
            image[i][j].r = clip(static_cast<int>(rtotal));
            image[i][j].g = clip(static_cast<int>(gtotal));
            image[i][j].b = clip(static_cast<int>(btotal));
        }
    }
}
