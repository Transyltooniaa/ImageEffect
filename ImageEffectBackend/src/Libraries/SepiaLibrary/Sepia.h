#ifndef SEPIA_H
#define SEPIA_H
#include <vector>
#include "../Pixel.h"

using namespace std;


//Applies sepia to a single pixel and returns the new pixel
Pixel ApplySepiaToPixel(Pixel& pixel);
vector<vector<Pixel> > ApplySepia(vector<vector<Pixel> >&image);

#endif