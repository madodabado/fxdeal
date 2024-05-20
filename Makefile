# Makefile for Spring Boot application

# Variables
APP_NAME := fxdeal-0.0.1-SNAPSHOT
JAR_FILE := $(APP_NAME).jar

# Targets
.PHONY: all
all: build

.PHONY: build
build:
	mvn clean package

.PHONY: run
run: build
	java -jar $(JAR_FILE)

.PHONY: clean
clean:
	mvn clean

.PHONY: help
help:
	@echo "Usage: make [target]"
	@echo "Targets:"
	@echo "  build   Build the fxdeal application"
	@echo "  run     Run the fxdeal application"
	@echo "  clean   Clean up build artifacts"
