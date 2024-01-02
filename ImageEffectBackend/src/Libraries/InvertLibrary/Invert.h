#ifndef INVERT_H
#define INVERT_H
#include "../Pixel.h"
#include <vector>
using namespace std;


// Invert the image by subtracting each color value from 255
void InvertEffect(vector<vector<Pixel> >& image);

#endif