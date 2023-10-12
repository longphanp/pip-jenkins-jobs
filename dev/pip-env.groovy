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

    configure {
        it / triggers << 'org.jenkinsci.plugins.gwt.GenericTrigger' {
          spec()
          token("pip_jenkins")
          causeString("Generic Cause")
        }
    }

    triggers {
        scm('* * * * *')
    }
}
