package com.batch.config;

import com.batch.model.User;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class SpringBatchConfig {

    @Bean
    public Job jobCreation(JobRepository jobRepository, JobCompletionNotification jobCompletionNotification,
                           Step step){
        return new JobBuilder("job", jobRepository)
                .listener(jobCompletionNotification)
                .start(step)
                .build();

    }

    @Bean
    public Step step(JobRepository jobRepository, DataSourceTransactionManager transactionManager,
    ItemReader<User> itemReader, ItemProcessor<User, User> itemProcessor, ItemWriter<User> itemWriter) {
        return new StepBuilder("jobStep", jobRepository)
                .<User, User>chunk(5, transactionManager)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }

    @Bean
    public FlatFileItemReader<User> reader(){
     return new FlatFileItemReaderBuilder<User>()
             .name("itemReader")
             .resource(new ClassPathResource("data.csv"))
             .delimited()
             .names("id", "name", "gender", "age")
             .targetType(User.class)
             .build();
    }

    @Bean
    public ItemProcessor<User, User> processor(){
        return new CustomItemProcessor();
    }

    @Bean
    public ItemWriter<User> writer(DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<User>()
                .sql("insert into Users(id,name,gender,age) values(:id, :name, :gender, :age)")
                .dataSource(dataSource)
                .beanMapped()
                .build();
    }

}
