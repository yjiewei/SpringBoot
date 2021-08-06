slf4j使用步骤

1. 配置logback.xml最重要
2. application.yml去加载配置文件，并设置日志级别
3. 使用 `private final static Logger logger = LoggerFactory.getLogger(Slf4jController.class);`