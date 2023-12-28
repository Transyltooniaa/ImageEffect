#ifndef CONTRAST_H
#define CONTRAST_H
#include "../Pixel.h"
#include<vector>

using namespace std;

//adjusts the contrast of the image by the given amount
void adjustContrast(vector<vector<Pixel> >& image, float amount);

#endif