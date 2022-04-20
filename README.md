Build

```
$ ./mvn clean package
```

Run

```
$ bin/armeria-thrift-out-of-memory-issue
```

Test

```
$ curl -d "foo\n" -H 'Content-Type: application/x-thrift' localhost:4567/
```
