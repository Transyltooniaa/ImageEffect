#include "Brightness.h"
#include "../Pixel.h"

#include <vector>
#include <algorithm>
using namespace std;


// Brightness filter
void applyBrightness(vector<vector<Pixel> >& image, float value) {

    for (int i = 0; i < image.size(); i++) {
        for (int j = 0; j < image[i].size(); j++)
        {
            // Add value to each color channel
            image[i][j].r = static_cast<int>(min(255.0f, max(0.0f, image[i][j].r + value)));
            image[i][j].g = static_cast<int>(min(255.0f, max(0.0f, image[i][j].g + value)));
            image[i][j].b = static_cast<int>(min(255.0f, max(0.0f, image[i][j].b + value)));
        }
    }
}
