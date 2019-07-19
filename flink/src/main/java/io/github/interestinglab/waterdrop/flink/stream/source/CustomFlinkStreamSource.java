package io.github.interestinglab.waterdrop.flink.stream.source;

import com.typesafe.config.Config;
import org.apache.flink.streaming.api.functions.source.RichParallelSourceFunction;

/**
 * @author mr_xiong
 * @date 2019-05-31 17:07
 * @description
 */
public abstract class CustomFlinkStreamSource<T> extends RichParallelSourceFunction<T> implements FlinkStreamSource<T> {

    protected Config config;

    protected volatile boolean isRunning = true;

    @Override
    public void setConfig(Config config) {
        this.config = config;
    }

    @Override
    public Config getConfig() {
        return config;
    }

    @Override
    public void cancel() {
        isRunning = false;
    }

}