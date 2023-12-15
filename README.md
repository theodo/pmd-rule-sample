1. How to build the new rule:
```
mvn clean install
```
in this repository.

2. How to install the rule in your project:
```
               <!-- PMD setup -->
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-pmd-plugin</artifactId>
                    <version>${maven-pmd-plugin.version}</version>
                    <dependencies>
                        ....
                        ....

                        <!-- MY OWN RULE -->
                        <dependency>
                            <artifactId>custom-java-rule</artifactId>
                            <groupId>org.gmi.pmd.rules</groupId>
                            <version>1.0.0</version>
                        </dependency>

                    </dependencies>

```
in your ``pom.xml`` file

and add the rule requirement here:
```
<?xml version="1.0" encoding="UTF-8"?>
<ruleset name="Default Maven PMD Plugin Ruleset"
    xmlns="http://pmd.sourceforge.net/ruleset/2.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://pmd.sourceforge.net/ruleset/2.0.0 http://pmd.sourceforge.net/ruleset_2_0_0.xsd">


    ...
    
    <!-- ASK for the rule to be activated -->
    <rule ref="custom/gmi/custom.xml/CustomRuleInJava" />

</ruleset>

```
in your ```pmd-rules.xml``` local to your project
