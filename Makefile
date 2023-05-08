.PHONY: test check clean build dist all

env:
	java --version
	@gradle -v

include z-gradle-base.mk
include playground/z-gradle.mk

help: helpGradleBase help-playground-gradle
	@echo "more task see makefile!"
