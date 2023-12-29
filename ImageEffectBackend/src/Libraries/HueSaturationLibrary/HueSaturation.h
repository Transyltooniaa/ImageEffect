#ifndef HUESATURATION_H
#define HUESATURATION_H
#include "../Pixel.h"
#include<vector>

using namespace std;

//Applies hue and saturation to the image
void applyHueSaturation(vector<vector<Pixel> >&image,float saturationValue,float hueValue);

#endif