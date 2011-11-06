package redis.client;

import org.junit.Test;
import redis.reply.Reply;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Test the boilerplate
 * <p/>
 * User: sam
 * Date: 11/5/11
 * Time: 10:20 PM
 */
public class RedisClientTest {
  @Test
  public void testIt() throws IOException, ExecutionException, InterruptedException {
    RedisClient redisClient = new RedisClient(new SocketPool("localhost", 6379));
    redisClient.set("test", "value");
    RedisClient.Pipeline pipeline = redisClient.pipeline();
    Future<Reply> test1 = pipeline.set("test1", "value1");
    Future<Reply> test2 = pipeline.set("test2", "value2");
    test2.get();
    test1.get();
  }
}
