#include "Grayscale.h"
#include<vector>
using namespace std;

// Function to apply grayscale effect
void ApplyGrayscale(vector<vector<Pixel> >& image)
{
    // Loop over image pixels
    for (int i = 0; i < image.size(); i++)
    {
        for (int j = 0; j < image[i].size(); j++)
        {
            // Using luminance formula to calculate average
            int lmf = image[i][j].r * 0.2126 +  image[i][j].g * 0.7152 +  image[i][j].b * 0.0722;

            // Assign average to each channel
            image[i][j].r = lmf;
            image[i][j].g = lmf;
            image[i][j].b = lmf;
        }
    }
}