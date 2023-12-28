#ifndef SEPIA_H
#define SEPIA_H
#include <vector>
#include "../Pixel.h"

using namespace std;

Pixel ApplySepiaToPixel(Pixel& pixel);
vector<vector<Pixel> > ApplySepia(vector<vector<Pixel> >&image);

#endif