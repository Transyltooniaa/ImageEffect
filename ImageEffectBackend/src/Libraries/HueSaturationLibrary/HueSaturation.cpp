#include "HueSaturation.h"
#include "../Pixel.h"

#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

// Helper function to clamp a value to the [0, 1] range
float clamp(float value, float minVal, float maxVal) {
    return max(min(value, maxVal), minVal);
}

void applyHueSaturation(vector<vector<Pixel> >& image, float saturationValue, float hueValue) {
    for (vector<Pixel>& row : image) {
        for (Pixel& pixel : row) {
            // Normalize RGB values to the range [0, 1]
            float r = pixel.r / 255.0f;
            float g = pixel.g / 255.0f;
            float b = pixel.b / 255.0f;

            // Find max and min values among r, g, b
            float maxVal = max(r, max(g, b));
            float minVal = min(r, min(g, b));


            float S, H;
            float L = (maxVal + minVal) / 2.0f;

            // Calculate saturation
            if (maxVal == minVal) {
                S = 0;
            } else {
                S = (L < 0.5) ? (maxVal - minVal) / (maxVal + minVal) : (maxVal - minVal) / (2.0f - maxVal - minVal);
            }

            // Calculate hue
            if (maxVal == minVal) {
                H = 0;
            } else if (maxVal == r) {
                H = (g - b) / (maxVal - minVal) + ((g < b) ? 6.0f : 0);
            } else if (maxVal == g) {
                H = 2.0f + (b - r) / (maxVal - minVal);
            } else {
                H = 4.0f + (r - g) / (maxVal - minVal);
            }

            // Normalize hue to the range [0, 1]
            H = fmod(H / 6.0f + hueValue, 1.0f);
            if (H < 0) {
                H += 1.0f;
            }

            // Adjust saturation and luminance
            S += saturationValue;
            S = clamp(S, 0.0f, 1.0f);
            L = clamp(L, 0.0f, 1.0f);

            // Calculate intermediate values
            float C = (1 - fabs(2 * L - 1)) * S;
            float X = C * (1 - fabs(fmod(H * 6, 2) - 1));
            float m = L - C / 2;

            // Calculate final RGB values
            float r_ = 0, g_ = 0, b_ = 0;
            if (H < 1.0f / 6) {
                r_ = C;
                g_ = X;
            } else if (H < 2.0f / 6) {
                r_ = X;
                g_ = C;
            } else if (H < 3.0f / 6) {
                g_ = C;
                b_ = X;
            } else if (H < 4.0f / 6) {
                g_ = X;
                b_ = C;
            } else if (H < 5.0f / 6) {
                r_ = X;
                b_ = C;
            } else {
                r_ = C;
                b_ = X;
            }

            // Update pixel values with clamping
            pixel.r = static_cast<unsigned char>(clamp((r_ + m) * 255, 0.0f, 255.0f));
            pixel.g = static_cast<unsigned char>(clamp((g_ + m) * 255, 0.0f, 255.0f));
            pixel.b = static_cast<unsigned char>(clamp((b_ + m) * 255, 0.0f, 255.0f));
        }
    }
}
