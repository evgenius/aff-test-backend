PROJECT_NAME = affinitas-test-task
PROJECT_VERSION = 1.0-SNAPSHOT
JAR_PATH = build/libs/$(PROJECT_NAME)-$(PROJECT_VERSION)-all.jar

usage:
	@echo "Usage: make run  - run the service"
	@echo "       make test - run the unit tests"
	@echo "       make at   - run the acceptance tests"

run:
	./gradlew shadowJar
	java -jar $(JAR_PATH)

test:
	./gradlew test

at:
	./gradlew at

clean:
	./gradlew clean
	rm -rf out
