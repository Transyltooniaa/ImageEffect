#include "Invert.h"
#include "../Pixel.h"
#include<cstdint>
#include <vector>

using namespace std;


// Invert the image.
void InvertEffect(vector<vector<Pixel> >& image)
{
    for (int i = 0; i < image.size(); i++) {
        for (int j = 0; j < image[i].size(); j++) {

            // Invert the color of each pixel.
            image[i][j].r = 255-image[i][j].r;
            image[i][j].g = 255-image[i][j].g;
            image[i][j].b = 255-image[i][j].b;

        }
    }
}