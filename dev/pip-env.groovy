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
                    branches('dev')
                }
            }
            scriptPath('pip-web/dev/Jenkinsfile')
        }
    }
}
