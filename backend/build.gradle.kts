plugins {
  id("org.springframework.boot") version "3.3.1"
  id("io.spring.dependency-management") version "1.1.5"
  kotlin("jvm") version "1.8.0"
  id("org.liquibase.gradle") version "2.1.1"
}

group = "com.complexica.lottery"
version = "0.0.1-SNAPSHOT"

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(17))
  }
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-validation")
  implementation("org.liquibase:liquibase-core")
  runtimeOnly("com.h2database:h2")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")

  liquibaseRuntime("org.liquibase:liquibase-core")
  liquibaseRuntime("com.h2database:h2")
  liquibaseRuntime("info.picocli:picocli:4.7.6")

}

liquibase {
  activities {
    create("main") {
      this.arguments = mapOf(
        "changeLogFile" to "src/main/resources/db/changelog/db.changelog-master.xml",
        "url" to "jdbc:h2:./data/lotterydb",
        "username" to "sa",
        "password" to "password",
        "driver" to "org.h2.Driver"
      )
    }
  }
  runList = "main"
}

tasks.register("liquibaseUpdate") {
  dependsOn("update")
}

tasks.withType<Test> {
  useJUnitPlatform()
}
