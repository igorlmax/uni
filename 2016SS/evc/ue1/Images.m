%
% Copyright 2016 Vienna University of Technology.
% Institute of Computer Graphics and Algorithms.
%

function[image_swapped, image_mark_green, image_masked, image_reshaped, image_convoluted, image_edge] = Images()

%% Initialization. Do not change anything here
input_path = 'lena_color.jpg';
output_path = 'lena_output.png';

image_swapped = [];
image_mark_green = [];
image_masked = [];
image_reshaped = [];
image_edge = [];


%% I. Images basics
% 1) Load image from 'input_path'

image = imread(input_path);

% 2) Convert the image from 1) to double format with range [0, 1]. DO NOT USE LOOPS.

imagedouble = im2double(image);

% 3) Use the image from 2) to create an image where the red and the blue channel
% are swapped. The result should be stored in image_swapped. DO NOT USE LOOPS.

image_swapped(:, :, 1) = imagedouble(:, :, 3);
image_swapped(:, :, 2) = imagedouble(:, :, 2);
image_swapped(:, :, 3) = imagedouble(:, :, 1);

% 4) Display the swapped image

imshow(image_swapped);

% 5) Write the swapped image to the path specified in output_path. The
% image should be in png format.

imwrite(image_swapped, output_path);

% 6) Create logical image where every pixel is marked that has a green channel
% which is greater or equal 0.5. The result should be stored in image_mark_green. 
% Use the image from step 2 for this step.
% DO NOT USE LOOPS.
% HINT:
% see http://de.mathworks.com/help/matlab/matlab_prog/find-array-elements-that-meet-a-condition.html).

image_mark_green = logical(imagedouble(:,:,2) >= 0.5)

% 7) Set all pixels in the original image (the double image from step 2) to black where image_mark_green is
% true (where green >= 0.5). Store the result in image_masked. 
% Use repmat to complete this task. DO NOT USE LOOPS. 
binaryRed = imagedouble(:,:,1) < 1;
binaryGreen = imagedouble(:,:,2) >= 0.5;
binaryBlue = imagedouble(:,:,3) < 1;
mask = binaryRed & binaryGreen & binaryBlue

image_masked = bsxfun(@times, imagedouble, cast(mask,class(imagedouble)));
imshow(image_masked);

% 8) Convert the original image (the double image from step 2) to a grayscale image and reshape it from
% 512x512 to 256x1024. Cut off the right half of the image and attach it to the bottom of the left half.
% The result should be stored in 'image_reshaped' DO NOT USE LOOPS.
% (Hint: Matlab adresses matrices with "height x width". 
% 	     The dimensions in the instructions refer to the human-readable form "width x height".
%		 If this is not clear, take a look at the resulting image in the online-instructions.)

image_reshaped = rgb2gray(imagedouble);
left = image_reshaped(:, 1:256);
right = image_reshaped(:, 257:end);
image_reshaped = cat(1, left, right);
imshow(image_reshaped);

%% II. Filters and convolutions

% 1) Use fspecial to create a 5x5 gaussian filter with sigma=2.0
%TODO: Delete the next line and add your code here
gauss_kernel = fspecial('gaussian', 5, 2.0);

% 2) Implement the evc_filter function. You are allowed to use loops for
% this task. You can assume that the kernel is always of size 5x5.
% For pixels outside the image use 0. 
% Do not use the conv or the imfilter or similar functions here. The result should be
% stored in image_convoluted
% The output image should have the same size as the input image.
image_convoluted = evc_filter(image_swapped, gauss_kernel);

% 3) Create a image showing the horizontal edges in image_reshaped using the sobel filter.
% For this task you can use imfilter/conv.
% Attention: Do not use evc_filter for this task!
% The result should be stored in image_edge. DO NOT USE LOOPS.
% The output image should have the same size as the input image.
% For this task it is your choice how you handle pixels outside the
% image, but you should use a typical method to do this.
%TODO: Add your code here

end

% Returns the input image filtered with the kernel
% input: An rgb-image
% kernel: The filter kernel
function [result] = evc_filter(input, kernel)
    for R = input(
    
    result = input;

end
