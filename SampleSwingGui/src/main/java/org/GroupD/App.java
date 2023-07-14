package org.GroupD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame
{
    private static final String SET_VIEW_RECRUITER = "SET_VIEW_RECRUITER";
    private static final String SET_VIEW_JOB_SEEKER = "SET_VIEW_JOB_SEEKER";

    private static final String RECRUITER_VIEW = "RECRUITER_VIEW";
    private static final String JOB_SEEKER_VIEW = "JOB_SEEKER_VIEW";
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton recruiterRadio;
    private JRadioButton jobSeekerRadio;
    private JPanel centralPanel;
    private JobSeekerView jobSeekerView;
    private RecruiterView recruiterView;

    private ButtonGroup viewButtonGroup;

    public App()
    {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);
        
        // view panel
        viewButtonGroup.setSelected(recruiterRadio.getModel(), true);
        recruiterRadio.setActionCommand(SET_VIEW_RECRUITER);
        jobSeekerRadio.setActionCommand(SET_VIEW_JOB_SEEKER);

        recruiterRadio.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                onViewChanged(e);
            }
        });

        jobSeekerRadio.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                onViewChanged(e);
            }
        });

        buttonOK.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener()
                                           {
                                               public void actionPerformed(ActionEvent e)
                                               {
                                                   onCancel();
                                               }
                                           },
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,
                        0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onViewChanged(ActionEvent e)
    {
        CardLayout cardLayout = (CardLayout) centralPanel.getLayout();
        switch (e.getActionCommand()) {
            case SET_VIEW_RECRUITER:
                cardLayout.show(centralPanel, RECRUITER_VIEW);
                break;
            case SET_VIEW_JOB_SEEKER:
                cardLayout.show(centralPanel, JOB_SEEKER_VIEW);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + e.getActionCommand());
        }
    }

    private void onOK()
    {
        // add your code here
        dispose();
    }

    private void onCancel()
    {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args)
    {
        App dialog = new App();
        dialog.pack();
        dialog.setVisible(true);
    }
}
