package org.gmi.pmd.rules;

import net.sourceforge.pmd.lang.java.ast.ASTMethodDeclaration;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

import java.util.Set;

public class ACustomRuleThatPreventRudeLanguage extends AbstractJavaRule {
    private final static Set<String> FORBIDDEN = Set.of("foo", "bar", "wizz");

    @Override
    public Object visit(ASTMethodDeclaration node, Object data) {
        // Looking for methods declarations in  the code

        // If the method name contains a forbidden word, add a violation.
        // Violation level and text are set up in XML file (custom.xml)
        String methodName = node.getName().toLowerCase();
        for (String searched : FORBIDDEN) {
            if(methodName.contains(searched)){
                asCtx(data).addViolation(node);
            }
        }

        return super.visit(node, data);
    }
}
