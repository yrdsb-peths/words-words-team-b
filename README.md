## Group B - Jacob, Marco, Yan, Kholly

## Data Structures
### Maps
- `GameWorld.java` - Mapping each character of the alphabet to the `Letter` object, as part of the on-screen alphabet display. A map is used because every letter is unique, and should have only one `Letter` object associated with it.
- `WordLoader.java` - Mapping each word to the category. A map is used because every word will have exactly one category assigned.

### Arrays
- `GameWorld.java` - Storing the list of word list file names, so a random list can be chosen by index. The values are defined at compile time, so an array works best.
- `GameWorld.java` - Storing the character array for the random word to guess, this makes it simple to access the letters by index. The length of the word is also known at assignment, so there is no need for a list.

### Lists
- `WordLoader.java` - In `getRandomWord()`, to contain all the keys in the word map. The number of keys is variable, so a list works best.
- `HangmanBodyParts.java`, `HangmanHead.java`- To contain the frames of the hangman gif. The number of frames in the gif is not known, so we use list.
