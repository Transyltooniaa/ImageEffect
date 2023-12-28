#include "Contrast.h"
#include "../Pixel.h"

#include <algorithm>
#include<cstdint>
#include <vector>

using namespace std;


// Adjusts the contrast of the image by the given amount.
void adjustContrast(vector<vector<Pixel> >& image, float amount)
{
    for (int i = 0; i < image.size(); i++)
    {
        for (int j = 0; j < image[i].size(); j++)
        {
            image[i][j].r = static_cast<uint8_t>(min(255.0f, max(0.0f, (image[i][j].r - 128) * amount + 128)));
            image[i][j].g = static_cast<uint8_t>(min(255.0f, max(0.0f, (image[i][j].g - 128) * amount + 128)));
            image[i][j].b = static_cast<uint8_t>(min(255.0f, max(0.0f, (image[i][j].b - 128) * amount + 128)));
        }
    }
}