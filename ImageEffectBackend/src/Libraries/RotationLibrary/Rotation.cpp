#include "Rotation.h"
#include "../Pixel.h"
#include<cstdint>
#include <vector>

using namespace std;

vector<vector<Pixel> > Rotate90(vector<vector<Pixel> >& image)
{
  vector<vector<Pixel> > rotatedImage(image[0].size(), vector<Pixel>(image.size()));
    for (size_t i = 0; i < image.size(); ++i) {
        for (size_t j = 0; j < image[i].size(); ++j) {
            rotatedImage[j][image.size() - 1 - i] = image[i][j];
        }
    }
    return rotatedImage;
}


// Rotate image 180 degrees
void Rotate180(vector<vector<Pixel> >& image){
//  Rotate 180 degrees by swapping pixels across the center
    for (size_t i = 0; i < image.size()/2; ++i){
        for (size_t j = 0; j < image[0].size(); ++j)
            swap(image[i][j], image[image.size() - 1 - i][image[0].size() - 1 - j]);
    }
}


// Alternate implementation of Rotate180 : Rotate 90 degrees twice
//void Rotate180(vector<vector<Pixel> >& image){
//     Rotate90(image);
//        Rotate90(image);
//}


// Rotate 270 degrees by rotating 180 degrees and then 90 degrees
vector<vector<Pixel> > Rotate270(vector<vector<Pixel> >& image)
{
  Rotate180(image);
  return Rotate90(image);
}



// Rotate 0 degrees
void Rotate0(vector<vector<Pixel> >& image){
//  zero degree no need to change anything
}



// Rotate image by value degrees
void RotationEffect(vector<vector<Pixel> >& image,int value){

  // 0 degree no need to change anything
  if(value == 0)
    Rotate0(image);

  // Rotate 90 degrees
  else if(value == 1)
    image = Rotate90(image);

  // Rotate 180 degrees
  else if(value == 2)
    Rotate180(image);

  // Rotate 270 degrees
  else if(value == 3)
    image = Rotate270(image);

}