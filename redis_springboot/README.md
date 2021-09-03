#### Redis是非关系型数据库，特点：分布式、开源、水平可扩展，key:value
#### NoSQL使用场景有：对数据高并发的读写、对海量数据的高效率存储和访问、对数据的高可扩展性和高可用性等
Redis的key可以是字符串、哈希、链表、集合和有序集合，value的类型可以是String,list,set,zset，而且为了保证效率，数据都是存储在内存中的。

**RedisTemplate 和 StringRedisTemplate**

我们不使用 RedisTemplate，
RedisTemplate 提供给我们操作对象，操作对象的时候，我们通常是以 json 格式存储，但在存储的时候，会使用 Redis 默认的内部序列化器；导致我们存进里面的是乱码之类的东西。当然了，我们可以自己定义序列化，但是比较麻烦，所以使用 StringRedisTemplate 模板。StringRedisTemplate 主要给我们提供字符串操作，我们可以将实体类等转成 json 字符串即可，在取出来后，也可以转成相应的对象，这就是上面我导入了阿里 fastjson 的原因。