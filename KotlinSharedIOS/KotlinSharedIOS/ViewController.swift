//
//  ViewController.swift
//  KotlinSharedIOS
//

import UIKit
import KotlinSharedLibrary

class ViewController: UIViewController {

    @IBOutlet weak var labelDemo: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let person = Person.init(name: "Alex", age: 25)        
        labelDemo.font = labelDemo.font.withSize(18)
		labelDemo.text = person.createApplicationScreenMessage()
    }
}
