# CountingShakespeare

Assignment:

https://github.com/datsoftlyngby/soft2019spring-algorithms/blob/master/Weeklies/Week_07/Assignment_02/02%20Assignment%20Searching%20Shakespeare.pdf


The objective is to basically take the .txt-file containing all of Shakespeares works and count the times a word is used.

This operation has to be achieved by building and using 4 types of Search algorithms, using Symbol Tables, in which the *words* are to be the *keys*, and the *number of occurrences* (of the word) should be the *values*.

The 4 algorithms are:

- LinkedList
- Array (Also known as FlexibleArray)
- Hashed
- BalancedTree (We went with the RedBlack-tree)

## Setup for Results

Just for a bit of clarification of the machine that was going to handle counting and searching this assignment:

*   **CPU**: *Intel i7-6700k / 4 Cores at 4.0GHz / 8 Threads*
*   **Ram**: *16GB DDR4 2666Mhz*
*   **Disk**: *2TB HDD*
*   **GPU**: *Nvidia 980TI 6GB GDDR5*
*   **OS**: *Windows 10 Pro, running on a 512GB SSD*

## Results
![results](./images.jpg)

Unlike the previous assignment ([SortingShakespeare](https://github.com/radeonxray/SortingShakespeare)), running this assignment and getting the results were a lot faster!

The current setup of the program has been set to run the complete Shakespeare.txt-file, so you can run the progrm and compare your own results.

- FlexibleArray: 14.665 Seconds
- LinkedList: 42.232 Seconds
- HashMap: 0.15 Seconds
- RedBlackBST 0.452 Seconds

Ranked on order from Fastest-to-Slowest:

1. HashMap: 0.15 Seconds
2. RedBlackBST 0.452 Seconds
3. FlexibleArray: 14.665 Seconds
4. LinkedList: 42.232 Seconds
