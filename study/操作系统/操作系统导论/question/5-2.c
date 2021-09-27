#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main(int argc, char *argv[])
{
    int fd = open("./p4.output", O_CREAT|O_WRONLY|O_TRUNC, S_IRWXU);
    int rc = fork();
    if (rc < 0) {
        fprintf(stderr, "fork failed\n");
        exit(1);
    } else if (rc == 0) {
        char str[50];
        sprintf(str, "hello, I am child (pid:%d)\n", (int) getpid());
        ssize_t res = write(fd, str, sizeof(str));
        printf("Child (pid:%d) write %d char to File\n", (int) getpid(), (int) res);
    } else {
        char str[50];
        sprintf(str, "hello, I am parent of %d (pid:%d)\n", rc, (int) getpid());
        ssize_t res = write(fd, str, sizeof(str));
        printf("Parent (pid:%d) write %d char to File\n", (int) getpid(), (int) res);
    }

    return 0;
}