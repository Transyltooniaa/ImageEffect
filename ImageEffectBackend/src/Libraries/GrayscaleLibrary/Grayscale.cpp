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
            // Get average of RGB values and assign it to each channel of the pixel (gray)
            int avg = (image[i][j].r + image[i][j].g + image[i][j].b) / 3;

            // Assign average to each channel
            image[i][j].r = avg;
            image[i][j].g = avg;
            image[i][j].b = avg;
        }
    }
}