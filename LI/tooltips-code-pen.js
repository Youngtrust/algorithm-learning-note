const OverlayTrigger = ReactBootstrap.OverlayTrigger;

const Tooltip = ReactBootstrap.Tooltip;

const renderTooltip = (props) => (
  <Tooltip {...props}>Tooltip for the register button</Tooltip>
);

const Hello = React.createClass({
  render() {
    return (
      <div>
        hi
        <OverlayTrigger
          placement="bottom"
          overlay={<Tooltip>Tooltip for the register button</Tooltip>}
        >
          <Button>Register</Button>
        </OverlayTrigger>
      </div>
    );
  },
});

ReactDOM.render(<Hello name="World" />, document.getElementById("container"));
