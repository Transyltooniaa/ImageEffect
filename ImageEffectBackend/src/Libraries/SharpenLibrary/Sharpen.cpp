#include <vector>
#include "../Pixel.h"
#include "Sharpen.h"

using namespace std;

// Function to apply sharpening to an image
void ApplySharpen(vector<vector<Pixel> >& resultImage, float amount) {

    // Define a 3x3 sharpening kernel
    float kernel[3][3] = {
        {-1 * amount, -1 * amount, -1 * amount},
        {-1 * amount, 9 * amount, -1 * amount},
        {-1 * amount, -1 * amount, -1 * amount}
    };

    int rows = resultImage.size();
    int cols = resultImage[0].size();

    // Apply the convolution operation
    for (int i = 1; i < rows - 1; ++i) {
        for (int j = 1; j < cols - 1; ++j) {
            int sumR = 0, sumG = 0, sumB = 0;

            // Apply the convolution kernel
            for (int k = -1; k <= 1; ++k) {
                for (int l = -1; l <= 1; ++l) {
                    sumR += resultImage[i + k][j + l].r * kernel[k + 1][l + 1];
                    sumG += resultImage[i + k][j + l].g * kernel[k + 1][l + 1];
                    sumB += resultImage[i + k][j + l].b * kernel[k + 1][l + 1];
                }
            }

            // Clamp values to the valid range [0, 255]
            resultImage[i][j].r = min(max(sumR, 0), 255);
            resultImage[i][j].g = min(max(sumG, 0), 255);
            resultImage[i][j].b = min(max(sumB, 0), 255);
        }
    }
}
