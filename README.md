# Family Tree
This program was from my data structure class. The program take input from a txt file with name of the father and the number of the sons to create a Left-Child Right-Sibling binary tree. The root of the binary tree will be the grandfather, the first son of the grandfather would be the left node and the rest of the sons would be the right node of their brothers.

For example: A is the grandfather, B-G are a's sons, H-J are sons of B, and N-O are sons of H.

![](https://github.com/d28601581/FamilyTree/blob/main/Left-Child%20Right-Sibling.png)

# Input
The input would be consist of lines of string and int. The string is the name of the father and int is number of the son.

The Example I use here:
Jones     3 (the root Jones has 3 sons: Bob, Dan, and Brian)
Bob       2 
Dan       0
Brian     1    
Richard   0 (Richard and Jake are the 2 sons of Bob)
Jake      1 
Michael   1 (the one son of Brian)
Bill      0 (the one son of Jake)
Deville   0 (the one son of Michael)

# Output
The output would first print out name of each member and the number of their sons, then it will print out the relationships of each member.
