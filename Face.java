import greenfoot.*;

public class Face extends Actor {
    GreenfootImage[] image = new GreenfootImage[4];
    Queue<GreenfootImage> queue = new Queue<>();
    GreenfootImage currentImage;
    
    int imageIndex = 0;
    int selectedImage;
    

    public Face(boolean isGame) {
        // Load images
        for (int i = 0; i < image.length; i++) {
            image[i] = new GreenfootImage("images/face" + i + ".png");
            queue.enqueue(image[i]);
        }

        // If the face is for the title screen, set the image to the selected image
        if (isGame) {
            setImage(image[selectedImage]);
        } else {
            setImage(image[3]);
            selectedImage = 3;
        }

    }

    public void changeImage() {
        if (!queue.isEmpty()) {
            // Dequeue the current image and enqueue the next image
            currentImage = queue.dequeue();
            setImage(currentImage);
            queue.enqueue(image[imageIndex]);
            imageIndex = (imageIndex + 1) % image.length;
            selectedImage++;

            if (selectedImage > 3) {
                selectedImage = 0;
            }
        }
    }

}