#ifndef BRIGHTNESS_H
#define BRIGHTNESS_H
#include "../Pixel.h"
#include<vector>

using namespace std;

//Function to apply brightness to the image
void applyBrightness(vector<vector<Pixel> >&image,float value);

#endif