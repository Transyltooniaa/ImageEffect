#include "Sepia.h"
#include "../Pixel.h"

#include <algorithm>
#include <vector>
using namespace std;


Pixel ApplySepiaToPixel(Pixel& pixel) {

    // Apply the sepia algorithm to a single pixel
    Pixel sepiaPixel;

    // Calculate the sepia values
    sepiaPixel.r = static_cast<int>(0.393 * pixel.r + 0.769 * pixel.g + 0.189 * pixel.b);
    sepiaPixel.g = static_cast<int>(0.349 * pixel.r + 0.686 * pixel.g + 0.168 * pixel.b);
    sepiaPixel.b = static_cast<int>(0.272 * pixel.r + 0.534 * pixel.g + 0.131 * pixel.b);

    // Clamp values to be in the valid range [0, 255]
    sepiaPixel.r = min(max(sepiaPixel.r, 0), 255);
    sepiaPixel.g = min(max(sepiaPixel.g, 0), 255);
    sepiaPixel.b = min(max(sepiaPixel.b, 0), 255);

    return sepiaPixel;
}



// Apply sepia to the image
vector<vector<Pixel> > ApplySepia(vector<vector<Pixel> >& image)
{
    // Create a new image to store the result
    vector<vector<Pixel> > resultImage;

    for ( int i = 0; i < image.size(); i++ )
    {

        // Create a new row of pixels
        vector<Pixel> resultRow;

        // Apply sepia to each pixel in the row
        for ( int j = 0; j < image[i].size(); j++ )
            resultRow.push_back(ApplySepiaToPixel(image[i][j]));

        // Add the row to the result image
        resultImage.push_back(resultRow);
    }

    return resultImage;
}

