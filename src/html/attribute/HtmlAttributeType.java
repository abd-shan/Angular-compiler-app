package html.attribute;

public enum HtmlAttributeType {
    ANGULAR_DIRECTIVE,      // *ngIf, *ngFor
    ANGULAR_PROPERTY,       // [src]
    ANGULAR_EVENT,          // (click)
    ANGULAR_TWO_WAY,        // [(ngModel)]
    STANDARD_ATTRIBUTE,     // class="..."
    BOOLEAN_ATTRIBUTE       // required, disabled
}
