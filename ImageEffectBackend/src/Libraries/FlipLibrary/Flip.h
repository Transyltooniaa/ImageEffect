#ifndef FLIP_H
#define FLIP_H
#include "../Pixel.h"
#include<vector>

using namespace std;


// Flips the image horizontally or vertically
void FlipImage(vector<vector<Pixel> >& image, int horizontal,int vertical);

#endif