#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

/**
 * result:
 * x:100
 * In parent 45197 x:100 before change
 * In parent 45197 x:300 after change
 * In child 45198 x:100 before change
 * In child 45198 x:200 after change 
 **/
int main(int argc, char *argv[])
{
    int x = 100;
    printf("x:%d\n", x);
    int rc = fork();
    if (rc < 0) {
        fprintf(stderr, "fork failed\n");
        exit(1);
    } else if (rc == 0) {
        printf("In child %d x:%d before change\n", (int) getpid(), x);
        x = 200;
        printf("In child %d x:%d after change\n", (int) getpid(), x);
    } else {
        printf("In parent %d x:%d before change\n", (int) getpid(), x);
        x = 300;
        printf("In parent %d x:%d after change\n", (int) getpid(), x);
    }

    return 0;
}