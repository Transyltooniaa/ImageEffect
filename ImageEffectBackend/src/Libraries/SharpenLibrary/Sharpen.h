#ifndef SHARPEN_H
#define SHARPEN_H
#include "../Pixel.h"
#include <vector>
using namespace std;

void ApplySharpen(vector<vector<Pixel> >& image,float amount);

#endif