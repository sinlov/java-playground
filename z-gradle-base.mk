# env PLATFORM OS_BIT ENV_ROOT ENV_HOME_PATH
ifeq ($(OS),Windows_NT)
  PLATFORM=Windows
  OS_BIT?=${shell if /i "%PROCESSOR_ARCHITECTURE%"=="AMD64" (echo x86_64) ELSE echo x86}
  # do windows powershell
  ENV_ROOT ?= $(shell pwd)
  ENV_HOME_PATH ?= ${shell echo %UserProfile%}
  # ENV_NOW_TIME_FORMAT = $(shell echo %Date:~0,4%%Date:~5,2%%Date:~8,2%)
  ENV_NOW_TIME_FORMAT=$(shell echo %Date:~0,4%-%Date:~5,2%-%Date:~8,2%-%time:~0,2%-%time:~3,2%-%time:~6,2%)
  ENV_GRADLE_WRAPPER=gradlew.bat
else
  OS_UNAME ?= $(shell echo `uname`) # Linux Darwin
  OS_BIT ?= $(shell echo `uname -m`) # x86_64 arm64
  ENV_ROOT ?= $(shell pwd)
  ENV_HOME_PATH ?= ${HOME}
  # ENV_NOW_TIME_FORMAT = $(shell date -u '+%Y-%m-%d-%H-%M-%S')
  ENV_NOW_TIME_FORMAT = $(shell date '+%Y-%m-%d-%H-%M-%S')
  ifeq ($(shell uname),Darwin)
    PLATFORM="MacOS"
    ifeq ($(shell echo ${OS_BIT}),arm64)
      PLATFORM="MacOS-Apple-Silicon"
    else
      PLATFORM="MacOS-Intel"
    endif
    # do MacOS

  else
    PLATFORM="Unix-Like"
    # do unix
  endif
  ENV_GRADLE_WRAPPER=./gradlew
endif

envBasic:
	@echo ------- start show env basic---------
	@echo ""
	@echo "PLATFORM                                  ${PLATFORM}"
	@echo "OS_BIT                                    ${OS_BIT}"
	@echo "ROOT_NAME                                 ${ROOT_NAME}"
	@echo "ENV_ROOT                                  ${ENV_ROOT}"
	@echo "ENV_NOW_TIME_FORMAT                       ${ENV_NOW_TIME_FORMAT}"
	@echo "ENV_HOME_PATH                             ${ENV_HOME_PATH}"
	@echo ""
	@echo "ENV_GRADLE_WRAPPER                        ${ENV_GRADLE_WRAPPER}"
	@echo ""
	@echo ------- end  show env basic ---------

# init this project
init:
	${ENV_GRADLE_WRAPPER} buildEnvironment --warning-mode all

cleanRoot:
	${ENV_GRADLE_WRAPPER} clean

# module module_shell_name
cleanGradleBuildAndIdea:
	${ENV_GRADLE_WRAPPER} clean cleanBuildCache cleanIdea

cleanBuildCatch:
	-@RM -r .gradle
	$(info has clean .gradle)
	-@RM -r buildCache
	$(info has clean buildCache)
	-@RM -r buildCacheDir
	$(info has clean buildCacheDir)

cleanAll: cleanGradleBuildAndIdea cleanBuildCatch
	@echo "clean all build !"

buildEnvironment:
	${ENV_GRADLE_WRAPPER} buildEnvironment

helpGradleBase:
	@echo "=> z-gradle-base.mk : gradle base task"
	@echo "make envBasic                -> print basic env"
	@echo "make init                    -> init this project for check base build error"
	@echo "make cleanRoot               -> run clean"
	@echo "make cleanGradleBuildAndIdea -> run clean cleanBuildCache cleanIdea"
	@echo "make cleanAll                -> run clean all"
	@echo ""