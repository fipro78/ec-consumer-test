package ecconsumereclipse;

import java.util.stream.Collectors;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import jakarta.annotation.PostConstruct;

public class EclipseCollectionsConsumer {
	
	@PostConstruct
	public void postConstruct(Composite parent) {
        parent.setLayout(new GridLayout(3, true));
        
        Label inputLabel = new Label(parent, SWT.NONE);
        inputLabel.setText("Strings to sort:");
        GridDataFactory.fillDefaults().applyTo(inputLabel);
 
        final Text input = new Text(parent, SWT.BORDER);
        GridDataFactory.fillDefaults().grab(true, false).applyTo(input);
 
        Button button = new Button(parent, SWT.PUSH);
        button.setText("Sort");
        GridDataFactory.defaultsFor(button).applyTo(button);
 
        Label outputLabel = new Label(parent, SWT.NONE);
        outputLabel.setText("Sorted Strings:");
        GridDataFactory.fillDefaults().applyTo(outputLabel);
 
        final Text output = new Text(parent, SWT.READ_ONLY | SWT.WRAP);
        GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(output);
 
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                output.setText(sort(input.getText()));
            }
        });
 
        input.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.keyCode == SWT.CR
                        || e.keyCode == SWT.KEYPAD_CR) {
                    output.setText(sort(input.getText()));
                }
            }
        });
    }
	
	String sort(String input) {
		String[] split = input.split(" ");
		MutableList<String> inputList = Lists.mutable.of(split);
		return inputList.sortThis().stream().collect(Collectors.joining(", "));
	}
}
