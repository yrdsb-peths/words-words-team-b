import greenfoot.*;

public class Face extends Actor {

    GreenfootImage[] image = new GreenfootImage[4];
    Queue<GreenfootImage> queue = new Queue<>();
    int imageIndex = 0;
    int selectedImage;
    GreenfootImage currentImage;  
    

    public Face(boolean isGame) {
        
        for(int i = 0;  i < image.length; i++)
        {
            image[i] = new GreenfootImage("images/face" + i + ".png");
            queue.enqueue(image[i]);
        }

        if(isGame) {
            setImage(image[selectedImage]);
        }else {
            setImage(image[3]);
            selectedImage= 3;
        }

    }

    public void changeImage() {
        if(!queue.isEmpty()) {
           currentImage = queue.dequeue(); 
           setImage(currentImage);
           queue.enqueue(image[imageIndex]);
           imageIndex = (imageIndex + 1) % image.length;
           selectedImage++;

           if(selectedImage > 3) {
               selectedImage = 0;
           }
        }
    }

}