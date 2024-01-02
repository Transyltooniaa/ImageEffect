#ifndef SHARPEN_H
#define SHARPEN_H
#include "../Pixel.h"
#include <vector>
using namespace std;


//Applies a sharpening filter to the image with the given amount
void ApplySharpen(vector<vector<Pixel> >& image,float amount);

#endif