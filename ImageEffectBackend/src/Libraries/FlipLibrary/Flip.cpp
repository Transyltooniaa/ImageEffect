#include <iostream>
#include <vector>
#include <algorithm>
#include "../Pixel.h"

using namespace std;

// Function to flip the image vector vertically
void flipVertical(vector<vector<Pixel> >& image) {
    reverse(image.begin(), image.end());
}

// Function to flip the image vector horizontally
void flipHorizontal(vector<vector<Pixel> >& image) {
    for (auto& row : image)
        reverse(row.begin(), row.end());
}


// Function to flip the image vector horizontally and vertically
void FlipImage(vector<vector<Pixel> >& image, int horizontal,int vertical)
{
    // If both horizontal and vertical are true, then flip the image vector horizontally and vertically
    if(horizontal && vertical)
    {
      flipHorizontal(image);
      flipVertical(image);
     }


     // If only horizontal is true, then flip the image vector horizontally
    if(horizontal)
      flipHorizontal(image);

    // If only vertical is true, then flip the image vector vertically
    if(vertical)
      flipVertical(image);
}