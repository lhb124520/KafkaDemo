package cn.kafka.demo.main;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * 描述: 生产者回调函数ProducerCallback
 *
 * @author : lhb
 * @date : 2020-09-11 16:39
 */
public class ProducerCallback implements Callback {

    @Override
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        /**
         *
         1 为了使用回调方法，需要实现org.apache.kafka.clients.producer.Callback接口,实现它的onCompletion方法。
         2 当Kafka返回错误的时候，onCompletion方法会收到一个非null的异常。上面的例子直接打印异常消息，但是如果是生产环境，需要做一些处理错误的操作。
         3 记录的创建和之前是一样的
         4 需要再发送消息的时候，传入回调的对象
         */
        if (exception != null) {
            exception.printStackTrace(); //2
        }
    }
}
