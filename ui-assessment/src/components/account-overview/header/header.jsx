import styled from "styled-components";

export const Header = ({ data }) => {
  
  const phone = data?.phone? data.phone : ''
  const email = data?.email? data?.email : ''
  const name = data?.name? data?.name : '-'
  const initial = name[0]

  const Title = styled.div`
      font-size: 2em;
      width: fit-content;
  `;

  const Wrapper = styled.div`
    width: 100%;
    display: flex;
    justify-content: space-around;
    align-items: ${props => props.alignItems};
  `
  
  const InformationTitle = styled.h5`
    color: gray;
    margin-bottom: 0.5em;
  `

  const Information = styled.div`
    width: fit-content;
  `

  const Contact = styled.div`
    width: 100%;  
    display: inline-flex;
    justify-content: space-between;
  `
  const Name = styled.div`
    font-weight: bold;
  `

  const Info = styled.div`
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    align-items: start;
  `

  const Initial = styled.div`
    padding: 1em;
    background-color: gold;
    border-radius: 10%;
    font-weight: bold;
    margin-right: 1em;
  `
  
    return (
      <Wrapper alignItems="center">
        <Title>Account overview</Title>
        <Information>
          <InformationTitle>YOUR FEEFO SUPPORT CONTACT</InformationTitle>
          <Wrapper>
            <Initial>{initial}</Initial>
            <Info>
              <Name>{name}</Name>
              <Contact>
                <div>{email}</div>
                <div>telefone</div>
              </Contact>
            </Info>
          </Wrapper>
        </Information>
      </Wrapper>
    )
  }