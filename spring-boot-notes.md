# Spring Boot + Kafka Interview Prep

## Spring Core
- IoC and Dependency Injection
- `@Component` vs `@Service` vs `@Repository` vs `@Controller`
- `@Bean` vs `@Component`
- Constructor vs field vs setter injection
- Bean lifecycle (`@PostConstruct`, `@PreDestroy`)
- Bean scopes (Singleton, Prototype, Request, Session)
- `BeanFactory` vs `ApplicationContext`
- Circular dependency (causes and fixes: `@Lazy`, setter injection)

## Spring Boot
- `@SpringBootApplication` = `@Configuration` + `@EnableAutoConfiguration` + `@ComponentScan`
- Auto-configuration mechanism (META-INF, `@ConditionalOnClass`)
- `application.properties` vs `application.yml`
- Profiles (`@Profile`)
- Spring Boot starters
- Actuator endpoints

## Spring MVC + REST
- `DispatcherServlet` and request lifecycle
- `@RestController` vs `@Controller`
- Filters vs Interceptors (Servlet level vs Spring MVC level)
- `@ControllerAdvice` and `@ExceptionHandler`
- `ResponseEntity`

## Transactions
- `@Transactional` internals (AOP proxy)
- Self-invocation problem (silently fails — bypasses proxy)
- `@Transactional` on private methods (silently fails)
- Propagation levels: REQUIRED, REQUIRES_NEW, NESTED, MANDATORY
- Isolation levels
- Rollback rules (checked vs unchecked)

## AOP
- Aspect-Oriented Programming basics
- `@Aspect`, `@Around`, `@Before`, `@After`
- JDK proxy vs CGLIB proxy

## Kafka
- Topics, partitions, offsets
- Producers and consumers
- Consumer groups (one partition per consumer per group)
- Rebalancing (triggers: join/leave/crash)
- Delivery guarantees: at-most-once, at-least-once, exactly-once
- Idempotent producer
- Transactional API
- Retention policy (time-based, default 7 days)
- Consumer lag and monitoring
- Kafka vs RabbitMQ
- Dead letter queues
- `@KafkaListener` in Spring Boot
- Manual vs auto offset commit
