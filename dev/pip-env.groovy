pipelineJob('pip-env') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        name('origin')
                        url('git@github.com:longphanp/pip-env.git')
                        credentials('jenkins-git')
                    }
                    branches('main')
                }
            }
            scriptPath('pip-web/dev/Jenkinsfile')
        }
    }

    steps {
        remoteTrigger('test-ci', 'test-flow') {
            token('pip_jenkins')
        }
    }

    triggers {
        scm('* * * * *')
    }
}
