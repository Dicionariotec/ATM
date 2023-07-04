node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    withSonarQubeEnv() {
      sh "./gradlew sonar"
    }
  }

  stage('JUnit tests') {
    withGradle {
      sh './gradlew test --scan'
    }
  }

  stage('Build') {
    withGradle {
      sh './gradlew build'
    }
  }

  stage('Upload') {
    nexusPublisher nexusInstanceId: 'ATMRespository', nexusRepositoryId: 'maven-releases', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: '/app/build/libs/app.jar']], mavenCoordinate: [artifactId: 'atm', groupId: 'com.dicionariotec.atm', packaging: 'jar', version: '1.0.0']]]
  }
}