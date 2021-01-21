    
1、 使用 GCLogAnalysis.java 自己演练一遍串行/并行/CMS/G1的案例。 

#### 512M 堆内存(60秒)
###### 串行GC:
```$xslt
java -Xmx512m -Xms512m -Xloggc:SerialGC.512.log -XX:+UseSerialGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```
###### 并行GC:
```$xslt
java -Xmx512m -Xms512m -Xloggc:ParallelGC.512.log -XX:+UseParallelGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```
###### CMSGC:
```$xslt
java -Xmx512m -Xms512m -Xloggc:ConcMarkSweepGC.512.log -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```
###### G1GC:
```$xslt
java -Xmx512m -Xms512m -Xloggc:G1GC.512.log -XX:+UseG1GC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```
| 512M堆内存| 生成对象次数 | YGC次数 | YGC时间 | FG次数 | FGC时间 | STW时间 |
| --- | --- | --- | --- | --- | --- |--- |
| SerialGC | 472376 | 11 | 160ms | 1044 | 44780ms | 44940ms 
| ParallelGC | 136677 | 31 | 250ms | 1109 | 54490ms | 54740ms
| CMSGC | 373714 | 761 | 40410ms | 4 | 180ms | 45930ms
| G1GC | 159560 | 2417 | 11170 | 564 | 19880 | 51479ms


#### 1G 堆内存(60秒)
###### 串行GC:
```$xslt
java -Xmx1024m -Xms1024m -Xloggc:SerialGC.1024.log -XX:+UseSerialGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```
###### 并行GC:
```$xslt
java -Xmx1024m -Xms1024m -Xloggc:ParallelGC.1024.log -XX:+UseParallelGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```
###### CMSGC:
```$xslt
java -Xmx1024m -Xms1024m -Xloggc:ConcMarkSweepGC.1024.log -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```
###### G1GC:
```$xslt
java -Xmx1024m -Xms1024m -Xloggc:G1GC.1024.log -XX:+UseG1GC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```
|1G堆内存 | 生成对象次数 | YGC次数 | YGC时间 | FG次数 | FGC时间 | STW时间 |
| --- | --- | --- | --- | --- | --- |--- |
| SerialGC | 1084584 | 777 | 12100ms | 244 | 12600ms | 24700ms 
| ParallelGC | 836634 | 1113 | 18400ms | 180 | 94600ms | 27860ms
| CMSGC | 1095369 | 937 | 16360ms | 98 | 5430ms | 22790ms
| G1GC | 900892 | 623 | 9580 | 1364 | 1290 | 29310ms


#### 2G 堆内存(60秒)
###### 串行GC:
```$xslt
java -Xmx2048m -Xms2048m -Xloggc:SerialGC.2048.log -XX:+UseSerialGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```
###### 并行GC:
```$xslt
java -Xmx2048m -Xms2048m -Xloggc:ParallelGC.2048.log -XX:+UseParallelGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```
###### CMSGC:
```$xslt
java -Xmx2048m -Xms2048m -Xloggc:ConcMarkSweepGC.2048.log -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```
###### G1GC:
```$xslt
java -Xmx2048m -Xms2048m -Xloggc:G1GC.2048.log -XX:+UseG1GC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```
|2G堆内存 | 生成对象次数 | YGC次数 | YGC时间 | FG次数 | FGC时间 | STW时间 |
| --- | --- | --- | --- | --- | --- |--- |
| SerialGC | 1222512 | 509 | 14270ms | 67 | 3860ms | 18130ms 
| ParallelGC | 1172094 | 827 | 18040ms | 64 | 2770ms | 20810ms
| CMSGC | 1237775 | 534 | 15050ms | 37 | 2210ms | 17730ms
| G1GC | 1245403 | 307 | 8570ms | 300 | 4110ms | 19680ms


#### 4G 堆内存(60秒)
###### 串行GC:
```$xslt
java -Xmx4096m -Xms4096m -Xloggc:SerialGC.4096.log -XX:+UseSerialGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```
###### 并行GC:
```$xslt
java -Xmx4096m -Xms4096m -Xloggc:ParallelGC.4096.log -XX:+UseParallelGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```
###### CMSGC:
```$xslt
java -Xmx4096m -Xms4096m -Xloggc:ConcMarkSweepGC.4096.log -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```
###### G1GC:
```$xslt
java -Xmx4096m -Xms4096m -Xloggc:G1GC.4096.log -XX:+UseG1GC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```

|4G堆内存 | 生成对象次数 | YGC次数 | YGC时间 | FG次数 | FGC时间 | STW时间 |
| --- | --- | --- | --- | --- | --- |--- |
| SerialGC | 1375636 | 305 | 13450ms | 19 | 1100ms | 14560ms 
| ParallelGC | 1344835 | 389 | 14640ms | 14 | 760ms | 15400ms
| CMSGC | 1282170 | 602 | 18500ms | 7 | 410ms | 1970ms
| G1GC | 1504726 | 231 | 9640ms | 19 | 440ms | 1120ms

##### 随着堆内存的增加，各个GC策略下程序GC次数逐渐减少，生成的对象也在逐渐增加。其中G1GC堆内存越大,程序的执行效率越高，其次为CMSGC与ParallelGC.
##### 需要注意的是，并不是内存越大越好，如果内存过大，GC的stw时间会变长，影响程序的吞吐量。吞吐量优先可以选择ParallelGC，低延迟优先可以选择CMSGC,系统内存堆较大(4G以上)，平均GC时间可控，使用G1GC。